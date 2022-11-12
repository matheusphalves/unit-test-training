import com.matheusphalves.unittest.fundamentals.models.User;
import org.junit.Assert;
import org.junit.Test;

public class AssertTest {


    @Test
    public void test(){
        Assert.assertTrue(true);
        Assert.assertFalse(false);
        Assert.assertEquals(1, 1);

        User user1 = new User("Matheus");
        User user2 = new User("Matheus");
        User user3 = null;

        Assert.assertEquals(user1, user2);
        Assert.assertSame(user1, user1);
        Assert.assertNull(user3);

    }
}
