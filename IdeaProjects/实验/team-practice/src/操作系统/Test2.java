package 操作系统;

import java.util.ArrayList;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = 4;
        Process[] processes = new Process[n];
        ArrayList<Process> index = new ArrayList<>(n);  // 用来保证之后排序后能找到原来顺序的引用
        System.out.println("请输入3个进程的名称、进入时刻和运行时间(3行，空格分隔)：");
        for (int i = 0; i < n; i++) {
            processes[i] = new Process();
            processes[i].setName(input.next());
            processes[i].setEnterTime(input.nextInt());
            processes[i].setRunTime(input.nextInt());
            index.add(processes[i]);
        }
        // 按进程的进入时间进行排序
        for (int i = 0; i < n - 1; i++) {
            int temp = i;
            for (int j = i + 1; j < n; j++) {
                if (processes[i].getEnterTime() > processes[j].getEnterTime())
                    temp = j;
            }
            swap(processes, i, temp);
        }
        for (int i = 0, time = processes[0].getEnterTime(); i < n; i++) {
            time += processes[i].getRunTime();  // 当前时刻time
            processes[i].setTurnaroundTime(time - processes[i].getEnterTime());
            int count = 0, tmp = 0;
            for (int j = i + 1; j < processes.length; j++) {
                // 若进程的进入时间小于等于当前时刻(就绪状态)，就算出它的响应比
                if (processes[j].getEnterTime() <= time) {
                    count++;    // 记录有几个进程在当前时刻都为就绪状态
                    if (count == 1)
                        tmp = j;    // 记录第一个在就绪状态的进程
                    float runTime = processes[j].getRunTime();
                    processes[j].setResponseRate((time + runTime - processes[j].getEnterTime()) / runTime);
//                    if (j != i + 1 && processes[j].getResponseRate() > processes[j - 1].getResponseRate()) {
//                        Process t = processes[j - 1];
//                        processes[j - 1] = processes[j];
//                        processes[j] = t;
//                    }
                }
            }
            // 把进入就绪状态的进程按响应比从大到小排序
            for (int j = tmp; j < tmp + count - 1; j++) {
                int temp = j;
                for (int k = j + 1; k < tmp + count; k++) {
                    if (processes[j].getResponseRate() < processes[k].getResponseRate())
                        temp = k;
                }
                swap(processes, j, temp);
            }
        }
        index.forEach(p -> System.out.print(p.getTurnaroundTime() + " "));
    }

    private static void swap(Process[] processes, int j, int temp) {
        Process t = processes[j];
        processes[j] = processes[temp];
        processes[temp] = t;
    }
}

class Process {
    private String name;    //进程名
    private int enterTime;  //进入时刻
    private int runTime;    //运行时间
    private int turnaroundTime; //周转时间
    private float responseRate; //响应比

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(int enterTime) {
        this.enterTime = enterTime;
    }

    public int getRunTime() {
        return runTime;
    }

    public void setRunTime(int runTime) {
        this.runTime = runTime;
    }

    public int getTurnaroundTime() {
        return turnaroundTime;
    }

    public void setTurnaroundTime(int turnaroundTime) {
        this.turnaroundTime = turnaroundTime;
    }

    public float getResponseRate() {
        return responseRate;
    }

    public void setResponseRate(float responseRate) {
        this.responseRate = responseRate;
    }
}
