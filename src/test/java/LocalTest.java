import java.time.OffsetDateTime;
import java.time.temporal.TemporalAdjusters;

public class LocalTest {

	public static void main(String[] args) {
		System.out.println(OffsetDateTime.now().with(TemporalAdjusters.firstDayOfNextMonth()));

	}

}
