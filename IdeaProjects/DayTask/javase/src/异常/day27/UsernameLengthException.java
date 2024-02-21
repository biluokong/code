package 异常.day27;

class UsernameLengthException extends Exception {
    public UsernameLengthException() {
    }

    @Override
    public String getMessage() {
        return "用户名长度不能小于6或长度大于14！";
    }
}
