import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Cpu {
    private Process process;
    private ArrayList<SharedResource> srl;
    private int rbs; //Resource being used

    public Cpu(){
        rbs =0;

    }

    public Cpu(Process process, ArrayList srl) {
        this.process = process;
        this.srl = srl;
    }

    public void stageProcess(Process process){
        process.setReady();
        this.process = process;
    }

    public void executeProcess(ArrayList<SharedResource> srl,int task){
        process.setRunning();

        System.out.println("Process Id: "+ process.getPid());
        System.out.println("Process State: " + process.getState());

        //Adding Data to the Shared Resource of a random index
        if(task == 0) {
            int randomData = (int) (Math.random() * 100);
            int randomIndex = (int) (Math.random() * 20);
            System.out.println("Adding Data for Index " + randomIndex);
            srl.get(randomIndex).setData(randomData);
            System.out.println("Data Added: = "+ randomData);
            System.out.println("Shared Resource "+  srl.get(randomIndex).toString());
        }else if (task == 1) {
            int randomIndex = (int) (Math.random() * 20);
            //Delete data from the Shared Resource
            System.out.println("Deleting Data for Index " + randomIndex);
            System.out.println("Shared Resource Previous value "+  srl.get(randomIndex).getData());

            //Setting the data to 0 of a random index
            srl.get(randomIndex).setData(0);
            System.out.println("Data Deleted: = " + srl.get(randomIndex).getData());
            System.out.println("Shared Resource "+  srl.get(randomIndex).toString());
        }else if(task == 2) {
            int randomIndex = (int) (Math.random() * 20);
            //Read data from the Shared Resource
            System.out.println("Reading Data for Index " + randomIndex);
            System.out.println("Data: "+srl.get(randomIndex).getData());
            System.out.println("Shared Resource "+  srl.get(randomIndex).toString());
        }else {
            int randomIndex = (int) (Math.random() * 20);
            //Calculating data from the shared resource
            System.out.println("Calculating Data");
            int total = 0;

            for(SharedResource srTmp : srl){
                total = srTmp.getData()+total;
            }
            System.out.println("Total: "+total);
            System.out.println("Shared Resource "+  srl.get(randomIndex).toString());
        }

        //Terminating the process
        process.setTerminated();
        System.out.println("Process State: " + process.getState());
        System.out.println();
    }

    public Process getProcess( ) {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public ArrayList<SharedResource> getSrl( ) {
        return srl;
    }

    public void setSrl(ArrayList<SharedResource> srl) {
        this.srl = srl;
    }

    public int getRbs( ) {
        return rbs;
    }

    public void setRbs(int rbs) {
        this.rbs = rbs;
    }

    @Override
    public String toString( ) {
        return "Cpu{" +
                "process=" + process +
                ", sharedResource=" + srl +
                '}';
    }
}
