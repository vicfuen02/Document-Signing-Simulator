package com.signingSimulator.signingSimulator.application.ports.input.signing;

import com.signingSimulator.signingSimulator.domain.signing.PostSingingContext;

public interface PostSigningHandler {


    PostSingingContext handle(PostSingingContext ctx);


}
