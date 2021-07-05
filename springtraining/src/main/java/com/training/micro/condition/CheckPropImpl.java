package com.training.micro.condition;

import java.util.Map;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class CheckPropImpl implements Condition {

    @Override
    public boolean matches(final ConditionContext contextParam,
                           final AnnotatedTypeMetadata metadataParam) {

        Map<String, Object> springBootVersion = metadataParam.getAnnotationAttributes(CheckProp.class.getCanonicalName());
        String objectLoc = (String) springBootVersion.get("value");
        if (objectLoc.equals("yukle")) {
            return true;
        }
        return false;
    }

}
