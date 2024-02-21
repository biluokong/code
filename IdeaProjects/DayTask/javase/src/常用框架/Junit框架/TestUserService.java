package 常用框架.Junit框架;

import org.junit.*;

/**
 * 测试类：可以测试单个方法和整个类中的所有测试方法
 *  注：在项目处右键还可以测试整个项目中的所有测试类中的测试方法
 */
public class TestUserService {
    //修饰静态方法的
    @BeforeClass
    public static void beforeClass() {
        System.out.println("===beforeClass方法执行了");
    }
    @AfterClass
    public static void afterClass() {
        System.out.println("===afterClass方法执行了");
    }

    //修饰实例方法的
    @Before
    public void before() {
        System.out.println("===before方法执行一次");
    }

    @After
    public void after() {
        System.out.println("===after方法执行一次");
    }

    /**
     * 测试方法：
     * ● 必须是公开的、无参数的、无返回值的、非静态的
     * ● 必须用@Test注解标记
     */
    @Test
    public void testLoginName() {
        UserService userService = new UserService();
        String s = userService.loginName("admin", "1234");

        //进行预期结果的准确性测试、断言
        Assert.assertEquals("业务出问题了", "登录成功", s);
    }

    @Test
    public void testSelectNames() {
        UserService userService = new UserService();
        userService.selectNames();
    }
}
