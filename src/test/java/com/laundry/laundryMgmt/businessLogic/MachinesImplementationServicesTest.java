package com.laundry.laundryMgmt.businessLogic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(OutputCaptureExtension.class)
@ExtendWith(SpringExtension.class)
public class MachinesImplementationServicesTest {

    @Configuration
    @ComponentScan("com.laundry.laundryMgmt.businessLogic")
    public static class MachinesImplementationServicesTestConfig{}

    @Autowired
    public MachinesServicesImplementation machinesServicesImplementation;

    @Test
    public void testWashingTimes(CapturedOutput output){
        machinesServicesImplementation.washingTimes(List.of(10, 20, 30 ), 60);
        Assertions.assertThat(output).contains("50", "40", "30");
    }

}
