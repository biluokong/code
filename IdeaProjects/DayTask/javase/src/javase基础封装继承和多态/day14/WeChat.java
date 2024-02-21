package javase基础封装继承和多态.day14;
//设计微信账号类，每个微信账号都有微信号、手机号、昵称等信息
public class WeChat {
    private String id;
    private String phoneNum;
    private String name;

    public WeChat(String id, String phoneNum, String name) {
        this.id = id;
        this.phoneNum = phoneNum;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "WeChat{" +
                "id='" + id + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
