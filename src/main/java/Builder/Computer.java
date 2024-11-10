package Builder;

import java.util.ArrayList;
import java.util.List;

public class Computer {
       private List<Configuration> configurations;

       public Computer(List<Configuration> configurations) {
              this.configurations = new ArrayList<>();
         }

    public Computer() {
           this.configurations = new ArrayList<>();

    }

    public void addConfiguration(Configuration configuration) {
                this.configurations.add(configuration);
            }

            public String toString() {
                StringBuilder sb = new StringBuilder();
                for (Configuration configuration : configurations) {
                    sb.append(configuration.getName());
                    sb.append("\n");
                }
                return sb.toString();
            }
}
