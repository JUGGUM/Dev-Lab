package hello.springmvc.basic.config.scheduler;

import org.springframework.stereotype.Service;

@Service
public class DeviceService {

    public void synchronize() {
        System.out.println("deviceService.synchronize");
    }
}
