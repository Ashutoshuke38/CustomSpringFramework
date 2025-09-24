package org.customspringframework.Routing.handler;

import java.util.List;

public class MappingHandlerFactory {
    private final List<MappingHandler> handlers = List.of(
            new GetMappingHandler(),
            new PostMappingHandler(),
            new PutMappingHandler(),
            new DeleteMappingHandler(),
            new RequestMappingHandler()
    );

    public List<MappingHandler> getHandlers() {
        return handlers;
    }
}
