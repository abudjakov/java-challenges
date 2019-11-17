package graph;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

@Slf4j
public class TubeTask {

    private Map<String, Station> tubeMap;

    public TubeTask(Map<String, Station> tubeMap) {
        this.tubeMap = tubeMap;
    }

    @Builder(toBuilder = true)
    @Accessors(fluent = true)
    @Getter
    @Setter
    private static class Station {
        private String name;
        private List<StationConnection> connections;

    }

    public enum Line {
        red,
        black,
        yellow
    }

    @Builder(toBuilder = true)
    @Accessors(fluent = true)
    @Getter
    public static class StationConnection {
        private Station station;
        private Line line;
        private int timeInSeconds;

    }

    // O(V + E)
    public int timeFrom(String from, String to) {
        Set<String> visited = new HashSet<>();

        Map<String, Integer> times = new HashMap<>();
        Map<String, String> parents = new HashMap<>();
        tubeMap.forEach((k, v) -> {
            times.put(k, Integer.MAX_VALUE);
        });
        times.put(from, 0);

        String current = from;
        while (current != null) {
            Station station = tubeMap.get(current);
            int run_time = times.get(station.name);

            visited.add(current);
            for (StationConnection connection : station.connections) {
                String adjacent = connection.station.name;
                int time = connection.timeInSeconds;
                if (visited.contains(adjacent)) continue;

                if (run_time + time < times.get(adjacent)) {
                    times.put(adjacent, run_time + time);
                    parents.put(adjacent, current);
                }
            }

            current = nextMinStation(times, visited);
        }

        String parent = parents.get(to);
        String path = to;
        while (parent != null) {
            path = parent + " -> " + path;
            parent = parents.get(parent);
        }
        log.info("path is: {}", path);

        return times.get(to);
    }

    // O(N) - partial selection sort
    private String nextMinStation(Map<String, Integer> times, Set<String> visited) {
        return times.entrySet().stream()
                .filter(e -> !visited.contains(e.getKey()))
                .min(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    // O(V + E)
    public Map<Line, Integer> linesStationCount() {
        Map<Line, Integer> lines = new HashMap<>();
        Map<String, Station> map = new HashMap<>(tubeMap);

        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            Station station = map.get(it.next());

            for (StationConnection connection : station.connections) {
                String adjacent = connection.station.name;
                Line line = connection.line;
                if (!map.containsKey(adjacent)) continue;

                lines.compute(line, (key, count) -> (count == null) ? 2 : count + 1);
            }
            it.remove();
        }

        return lines;
    }


    public static void main(String[] args) {
        Map<String, Station> tubeMap = tubeMap();
        TubeTask tubeTask = new TubeTask(tubeMap);
        log.info("time from {} to {} is {}", "a", "d", tubeTask.timeFrom("a", "d")); // 6
        log.info("tube linesStationCount: {}", tubeTask.linesStationCount());
    }

    private static Map<String, Station> tubeMap() {
        Station a = Station.builder().name("a").build();
        Station b = Station.builder().name("b").build();
        Station c = Station.builder().name("c").build();
        Station d = Station.builder().name("d").build();
        Station e = Station.builder().name("e").build();
        Station f = Station.builder().name("f").build();
        Station g = Station.builder().name("g").build();

        StationConnection ab = StationConnection.builder().line(Line.yellow).station(b).timeInSeconds(2).build();
        StationConnection ba = StationConnection.builder().line(Line.yellow).station(a).timeInSeconds(2).build();
        StationConnection bc = StationConnection.builder().line(Line.yellow).station(c).timeInSeconds(3).build();
        StationConnection cb = StationConnection.builder().line(Line.yellow).station(b).timeInSeconds(3).build();
        StationConnection ae = StationConnection.builder().line(Line.black).station(e).timeInSeconds(1).build();
        StationConnection ea = StationConnection.builder().line(Line.black).station(a).timeInSeconds(1).build();
        StationConnection cd = StationConnection.builder().line(Line.yellow).station(d).timeInSeconds(2).build();
        StationConnection dc = StationConnection.builder().line(Line.yellow).station(c).timeInSeconds(2).build();
        StationConnection ec = StationConnection.builder().line(Line.red).station(c).timeInSeconds(3).build();
        StationConnection ce = StationConnection.builder().line(Line.red).station(e).timeInSeconds(3).build();
        StationConnection eg = StationConnection.builder().line(Line.black).station(g).timeInSeconds(2).build();
        StationConnection ge = StationConnection.builder().line(Line.black).station(e).timeInSeconds(2).build();
        StationConnection ef = StationConnection.builder().line(Line.red).station(f).timeInSeconds(2).build();
        StationConnection fe = StationConnection.builder().line(Line.red).station(e).timeInSeconds(2).build();


        a.connections(asList(ab, ae));
        b.connections(asList(ba, bc));
        c.connections(asList(cb, cd, ce));
        d.connections(asList(dc));
        e.connections(asList(ea, ec, ef, eg));
        f.connections(asList(fe));
        g.connections(asList(ge));

        return Stream.of(a, b, c, d, e, f, g)
                .collect(Collectors.toMap(Station::name, Function.identity()));
    }
}

