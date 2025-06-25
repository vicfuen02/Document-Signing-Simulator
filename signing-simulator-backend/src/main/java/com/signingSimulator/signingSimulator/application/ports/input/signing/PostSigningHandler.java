package com.signingSimulator.signingSimulator.application.ports.input.signing;

import com.signingSimulator.signingSimulator.domain.PostSingingContext;

public interface PostSigningHandler {


    PostSingingContext handle(PostSingingContext ctx);


}
