package callengineer;

import callengineer.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;

@Service
public class PolicyHandler{
    @Autowired EngineerManagementRepository engineerManagementRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPaymentApproved_RequestInformationReceived(@Payload PaymentApproved paymentApproved){

        if(!paymentApproved.validate()) return;

        System.out.println("\n\n##### listener RequestInformationReceived : " + paymentApproved.toJson() + "\n\n");


        

        // Sample Logic //
        EngineerManagement engineerManagement = new EngineerManagement();
        engineerManagement.setCallId(paymentApproved.getCallId());
        engineerManagement.setStatus("1");
        System.out.println("\n\n##### listener RequestInformationReceived : " + engineerManagement.toString() + "\n\n");
        engineerManagementRepository.save(engineerManagement);

    }


}


