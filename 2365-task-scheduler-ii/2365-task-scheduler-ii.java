class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        long days = 0;
        Map<Integer, Long> tasksLastDays = new HashMap<>();
        
        for (int i = 0; i < tasks.length; i++) {
            days++;
            
            Long taskLastDay = tasksLastDays.get(tasks[i]);
            if (taskLastDay != null && days - taskLastDay <= space ) {
                days = taskLastDay + space + 1;
            }
            
            tasksLastDays.put(tasks[i], days);
        }
        
        return days;
    }
}