import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
       private static Process process;
        private static ArrayList<SharedResource> srl;
        private static PriorityQueue<Process> pq;

    public static void main(String[] args){

        process = new Process(0);
        srl = new ArrayList<>();
        pq = new PriorityQueue<Process>(20, new ProComparator());

        loadResources();
        loadProcess();
        System.out.println("\n-----------------------------------------------------------------------------------------");

        Cpu core1 =new Cpu();
        Cpu core2 =new Cpu();

        int srlIndex = 0;

        while(!pq.isEmpty()){

            if(!pq.isEmpty()) {

                //Getting Processes from the priority queue
                Process process1 = pq.poll();
                Process process2 = pq.poll();

                //The smaller value for the tasks takes higher Priority
                if (process1.getTask() < process2.getTask()) {

                    //Assigning the process to the CPU core 1
                    core1.stageProcess(process1);
                    System.out.println("Core1: " + process1);

                    //Executing the process and storing the index for the next resource
                    srlIndex = core1.executeProcess(srl, srlIndex, process1.getTask());

                    //Assigning the process to the CPU core 2
                    core2.stageProcess(process2);

                    //Checking for deadlock
                    if((process1.getTask() == 1 || process1.getTask() == 0) &&
                            (process2.getTask() ==1 || process2.getTask() == 0)) {
                        System.out.println("Locking Mechanism : Mutual Exclusion");
                        process2.setBlocked();
                        System.out.println("Process State: " +process2.getState());
                        process2.setBlockedTime(process1.getBurstTime());
                    }

                    //Executing the process and storing the index for the next resource
                    System.out.println("Core2: " + process2);
                    srlIndex = core2.executeProcess(srl, srlIndex, process2.getTask());
                } else {

                    //Assigning the process to the CPU core 1
                    System.out.println("Core1: " + process2);
                    core1.stageProcess(process2);
                    srlIndex =  core1.executeProcess(srl, srlIndex, process2.getTask());

                    //Assigning the process to the CPU core 2
                    core2.stageProcess(process1);

                     //Checking for deadlock
                    if((process1.getTask() == 1 || process1.getTask() == 0) &&
                            (process2.getTask() ==1 || process2.getTask() == 0)) {
                        System.out.println("Locking Mechanism : Mutual Exclusion");
                        process1.setBlocked();
                        System.out.println("Process State: " + process1.getState());
                        process1.setBlockedTime(process2.getBurstTime());
                    }

                    //Executing the process and storing the index for the next resource
                    System.out.println("Core2: " + process1);
                    srlIndex = core2.executeProcess(srl, srlIndex, process1.getTask());
                    }
                }
            }

        System.out.println("-----------------------------------------------------------------------------------------");
        //Printing the final state of the resources
        System.out.println("Accessed Resources");
        for(SharedResource sr : srl){
            System.out.println(sr);
        }
        //Printing the final state of the process queue
        System.out.println("\nChecking Processes");
        try {
            if (pq.isEmpty()) {
                System.out.println("Process all processes have been executed");
            }else {
                for (Process pro : pq) {
                    System.out.println(pro);
                    throw new Exception("Process not executed");
                }
            }
        }catch (Exception e){
            System.err.println("Processes did not execute properly");
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

        //load processes
        for(int i = 0; i < 20; i++) {
            pq.add(new Process(i));
        }
        for(Process l : pq){
            System.out.println(l);
        }
        return pq;
    }
}