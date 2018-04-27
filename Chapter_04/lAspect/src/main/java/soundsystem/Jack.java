package soundsystem;

import org.springframework.stereotype.Component;

@Component
public class Jack implements Singer {
    @Override
    public void singing() {
        System.out.println("Jack");
    }
}
