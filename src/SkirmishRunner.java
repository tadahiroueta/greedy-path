import java.io.*;

public class SkirmishRunner {
    public static void main(String[] args) throws IOException {
        System.out.println(new GreedyPath("points7.txt").getDistance());
        System.out.println(new GreedyPath("mona-20k.txt").getDistance());
        System.out.println(new GreedyPath("usa13509.txt").getDistance());
    }
}
