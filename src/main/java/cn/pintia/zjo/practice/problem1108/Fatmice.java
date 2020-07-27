package cn.pintia.zjo.practice.problem1108;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

class Node implements Comparable<Node>{
    int w;
    int s;
    int index;

    public Node(int w,int s,int index) {
        this.w=w;
        this.s=s;
        this.index=index;
    }

    @Override
    public int compareTo(Node o) {
        if(this.w!=o.w)
            return this.w-o.w;
        else {
            if(this.s!=o.s)
                return o.s-this.s;
            else
                return 0;
        }
    }
}

public class Fatmice {
    public static final int max=1010;

    public static boolean check(Node a,Node b) {
        return a.w<b.w&&a.s>b.s;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(new BufferedInputStream(System.in));
        int[] dp=new int[max];
        int[] pre=new int[max];
        Node[] buf=new Node[max];
        int index=0;
        int ans=0;
        int maxIndex=0;

        while(sc.hasNext()) {
            int w=sc.nextInt();
            int s=sc.nextInt();
            buf[index]=new Node(w,s,index);
            index++;
        }
        Arrays.sort(buf,0,index);
        for(int i=0;i<index;i++) {
            if(dp[i]==0) {
                dp[i]=1;
                pre[buf[i].index]=buf[i].index;
            }
            for(int j=i+1;j<index;j++) {
                if(check(buf[i],buf[j])) {
                    if(dp[j]<dp[i]+1) {
                        dp[j]=dp[i]+1;
                        pre[buf[j].index]=buf[i].index;
                        if(ans<dp[j]) {
                            maxIndex=buf[j].index;
                            ans=dp[j];
                        }
                    }
                }
            }
        }
        System.out.println(ans);
        int[] res=new int[ans];
        int pos=ans-1;
        res[pos]=maxIndex;
        while(maxIndex!=pre[maxIndex]) {
            maxIndex=pre[maxIndex];
            res[--pos]=maxIndex;
        }
        for(int i=0;i<ans;i++) {
            System.out.println(res[i]+1);
        }
    }
}