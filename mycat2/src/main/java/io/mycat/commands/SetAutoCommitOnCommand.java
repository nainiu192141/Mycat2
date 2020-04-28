package io.mycat.commands;

import io.mycat.MycatDataContext;
import io.mycat.client.SQLRequest;
import io.mycat.util.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SetAutoCommitOnCommand implements MycatCommand {
    final static Logger LOGGER = LoggerFactory.getLogger(SetAutoCommitOnCommand.class);
    @Override
    public boolean run(SQLRequest request, MycatDataContext context, Response response) {
        context.setAutoCommit(true);
        LOGGER.debug("session id:{} action:set autocommit = 1 exe success", request.getSessionId());
        response.sendOk();
        return true;
    }

    @Override
    public boolean explain(SQLRequest request, MycatDataContext context, Response response) {
        response.sendExplain(SetAutoCommitOnCommand.class,"SET_AUTOCOMMIT_ON");
        return true;
    }

    @Override
    public String getName() {
        return "setAutoCommitOn";
    }
}