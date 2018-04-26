package soundsystem;

import org.springframework.stereotype.Component;

@Component
public class Tony implements Singer{
    public void singing() {
        System.out.println("i'm singing");
    }
}
