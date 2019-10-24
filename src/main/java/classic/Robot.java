package classic;

import java.util.Random;

/*
You have a robot half-way up an infinite staircase.
The robot has a function, Step(), which makes the robot go up or down a step, non-deterministically.
50% of the time the robot goes up one step and the function returns True.
50% of the time the robot goes down one step and the function returns False.
Write a function StepUp() which makes the robot go up one step.
 */
public class Robot {

    public int step = 0;

    private Random random = new Random();

    public boolean step() {
        boolean result = random.nextBoolean();
        System.out.println(result);
        step += result ? 1 : -1;
        return result;
    }

    public void stepUp() {
        if (step()) {
            return;
        }
        stepUp();
        stepUp();
    }

    public void stepUp2() {
        int i = 0;
        while (i != 1) {
            i += step() ? 1 : -1;
        }
    }

    public static void main(String[] args) {
        Robot robot = new Robot();
//        robot.stepUp();
        robot.stepUp2();
        System.out.println("step: " + robot.step);
    }
}
