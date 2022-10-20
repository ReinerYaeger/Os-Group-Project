public class Process {
    private int pid;
    private int task;
    private int priority;
    private int arrivalTime;
    private int blockedTime;
    private int burstTime;

    public Process(){
        this.pid = 0;
        this.task = 0;
        this.priority = 0;
        this.arrivalTime = 0;
        this.blockedTime = 0;
        this.burstTime = 0;
    }

    public Process(int pid, int task, int priority, int arrivalTime, int blockedTime, int burstTime) {
        this.pid = pid;
        this.task = task;
        this.priority = priority;
        this.arrivalTime = arrivalTime;
        this.blockedTime = blockedTime;
        this.burstTime = burstTime;
    }

    public int getPid( ) {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getTask( ) {
        return task;
    }

    public void setTask(int task) {
        this.task = task;
    }

    public int getPriority( ) {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getArrivalTime( ) {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getBlockedTime( ) {
        return blockedTime;
    }

    public void setBlockedTime(int blockedTime) {
        this.blockedTime = blockedTime;
    }

    public int getBurstTime( ) {
        return burstTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    @Override
    public String toString( ) {
        return "Process{" +
                "pid=" + pid +
                ", task=" + task +
                ", priority=" + priority +
                ", arrivalTime=" + arrivalTime +
                ", blockedTime=" + blockedTime +
                ", burstTime=" + burstTime +
                '}';
    }
}
