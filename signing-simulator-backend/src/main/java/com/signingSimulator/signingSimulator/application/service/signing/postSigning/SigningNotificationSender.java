package com.signingSimulator.signingSimulator.application.service.signing.postSigning;

import com.signingSimulator.signingSimulator.application.ports.input.notification.NotificationService;
import com.signingSimulator.signingSimulator.application.ports.input.signing.PostSigningHandler;
import com.signingSimulator.signingSimulator.domain.Document;
import com.signingSimulator.signingSimulator.domain.NotificationRequest;
import com.signingSimulator.signingSimulator.domain.PostSingingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Order(2)
public class SigningNotificationSender implements PostSigningHandler {

    private static final Logger log = LogManager.getLogger(SigningNotificationSender.class);


    private NotificationService notificationService;

    @Autowired
    public SigningNotificationSender(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Override
    public PostSingingContext handle(PostSingingContext ctx) {
        log.info("SigningNotificationSender -- START");

        NotificationRequest notificationRequest = new NotificationRequest.Builder()
                .setUserId(ctx.getCertificate().getUser().getId())
                .setInfo(ctx.getDocument().getDocument())
                .build();

        notificationService.send(notificationRequest);
        ctx.setHandledSuccessfully(true);
        
        log.info("SigningNotificationSender -- END");
        return ctx;
    }


}
