import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
       private static Process process;
        private static ArrayList<SharedResource> srl;
        private static PriorityQueue<Process> pq;

    public static void main(String[] args){

        process = new Process();
        srl = new ArrayList<>();
        pq = new PriorityQueue<Process>(20, new ProComparator());

        loadResources();
        loadProcess();

        Cpu core1 =new Cpu();
        Cpu core2 =new Cpu();

        int srlIndex = 0;




        while(!pq.isEmpty()){

            if(!pq.isEmpty()) {
                //Load the process into the cpu without executing it
                //Verify operation before execution
                //Add use task the priority operator to determine the operation

                //Implement blocking
                Process process1 = pq.poll();
                Process process2 = pq.poll();

                if (process1.getTask() < process2.getTask()) {
                    core1.stageProcess(process1);
                    System.out.println("Core1: " + process1);
                    srlIndex = core1.executeProcess(srl, srlIndex, process1.getTask());

                    core2.stageProcess(process2);
                    process2.setBlockedTime(process1.getBurstTime());
                    System.out.println("Core2: " + process1);
                    srlIndex = core2.executeProcess(srl, srlIndex, process2.getTask());
                } else {
                    System.out.println("Core1: " + process1);
                    core1.stageProcess(process2);
                    srlIndex =  core1.executeProcess(srl, srlIndex, process2.getTask());

                    core2.stageProcess(process1);
                    process1.setBlockedTime(process2.getBurstTime());
                    System.out.println("Core2: " + process1);
                    srlIndex =  core2.executeProcess(srl, srlIndex, process1.getTask());
                    }
                }
            }

        System.out.println("Accessed Resources");
        for(SharedResource sr : srl){
            System.out.println(sr);
        }

        System.out.println("Printing Processes");
        for(Process pro : pq){
            System.out.println(pro);
        }
    }

    public static void loadResources(){
        //load resources
        for(int i = 0; i < 20; i++){
            srl.add(new SharedResource(i, 0));
        }

        for(SharedResource l : srl){
            System.out.println(l);
        }
    }

    public static PriorityQueue loadProcess(){

        //loop that counts to 20
        for(int i = 0; i < 20; i++) {
            pq.add(new Process());
        }
        for(Process l : pq){
            System.out.println(l);
        }
        return pq;
    }
}