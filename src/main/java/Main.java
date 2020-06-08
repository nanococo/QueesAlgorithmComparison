import java.time.Duration;
import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        int size = 14;

        Instant startsBackTracking = Instant.now();
        BacktrackingQueens backtrackingQueens = new BacktrackingQueens(size);
        Instant endsBacktracking = Instant.now();
        System.out.println(Duration.between(startsBackTracking, endsBacktracking).toMillis());

        System.out.println("----------------------------");


        Instant startsRandomized = Instant.now();
        RandomizedQueens randomizedQueens = new RandomizedQueens(size);
        Instant endsRandomized = Instant.now();
        System.out.println(Duration.between(startsRandomized, endsRandomized).toMillis());
    }
}
