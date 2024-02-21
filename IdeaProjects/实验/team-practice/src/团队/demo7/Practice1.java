package 团队.demo7;

public class Practice1 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 0, 4};
        //获取最后一个下标的位置
        int n = nums.length;
        //当前能跳的最长距离
        int rightMost = 0;
        //遍历整个数组
        for(int i = 0; i < n; i++){
            //如果当前下标小于等于更新后目前能跳的最长距离，证明还不能跳到数组的最后一个位置；大于的话，进入下一个循环（证明当前不可达）
            if(i <= rightMost){
                //更新当前能跳的最长距离
                rightMost = Math.max(rightMost, i + nums[i]);
                //如果当前能跳的最长距离大于数组的最后一个下标，则返回true
                if(rightMost >= n - 1){
                    System.out.println(true);
                    return;
                }
            }
        }
        System.out.println(false);
    }
}
