class fcfs{
public static void findwait(int processes[],int brst[],int num,int[] wt){
    wt[0]=0;
    for(int i=1;i<num;i++){
        wt[i]=brst[i-1]+wt[i-1];

    }
}
public static void findtat(int processes[],int brst[],int num,int []tat,int[]wt){
    tat[0]=brst[0];
    for(int i=1;i<num;i++){
        tat[i]=brst[i]+wt[i];
    }

}
 
 

public static void findavg(int processes[],int brst[],int num){
    int[] wt=new int[num];
    int[] tat=new int[num];
    findwait(processes,brst,num,wt);
    findtat(processes, brst, num, tat, wt);
    int Twt=0,Ttat=0;
    for(int i=0;i<num;i++){
       Twt=Twt+wt[i];
       Ttat=Ttat + tat[i];
    }
    
    System.out.println("Total turnaround time="+Ttat);
    System.out.println("Total waiting time="+Twt);
    System.out.println("Average turnaround time="+Ttat/num);
    System.out.println("Average waiting time="+Twt/num);

 }
public static void main(String[] args) {
    int[] process={1,2,3};
    int n=process.length;
    int[] burst={10,5,8};
    findavg(process, burst, n);

}
}