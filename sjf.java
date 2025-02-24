import java.util.*; 
public class sj {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the no of processes:");
        int n= sc.nextInt();
        int [][] p=new int[n][4];
        System.out.println("Enter the  burst time of the processes");
        for(int i=0;i<n;i++){
            System.out.print("P"+(i+1)+":");
            p[i][1]=sc.nextInt();//At 1 position burst time is 
            p[i][0]=i+1;
        }

        for(int i=0;i<n-1;i++){
            int idx=i;
            for(int j=i+1;j<n;j++){
                if(p[j][1]<p[idx][1]){
                    idx=j;
                }
            }
            int temp=p[idx][1];
            p[idx][1]=p[i][1];  
            p[i][1]=temp;
            int index=p[idx][0];
            p[idx][0]=p[i][0];
            p[i][0]=index;

        }
        //calculating wt
        int total=0;
        p[0][2]=0;
        for(int i=1;i<n;i++){
            p[i][2]=0;
            for(int j=0;j<i;j++){
                p[i][2]+=p[j][1];

            }
            total+=p[i][2];

        }
        total=0;
        float avg=total/n;
        for (int i = 0; i < n; i++) {
            p[i][3]=p[i][1]+p[i][2];
            total+=p[i][3];
            
        }
        float avg_tat=total/n;
        System.out.println("Process"+"\t"+"BT"+"\t"+"WT"+"\t"+"TAT");
        for(int i=0;i<n;i++){
            System.out.println(p[i][0]+"\t"+p[i][1]+"\t"+p[i][2]+"\t"+p[i][3]);
        }
    }
        
    }
    

