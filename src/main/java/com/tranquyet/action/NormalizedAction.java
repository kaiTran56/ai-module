package com.tranquyet.action;

import com.tranquyet.Constants;
import com.tranquyet.dto.DelayTimeDto;
import com.tranquyet.dto.KeyboardActionDto;
import com.tranquyet.dto.MouseActionDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class NormalizedAction {

    public List<Object> normalizedData(List<Object> actions){
        List<Object> customizedActions = new ArrayList<>();
        int size = actions.size();
        IntStream.range(0, size).filter(idx -> idx < size-2).forEach(idx->{
            int before = idx;
            int nxt = idx + 1;
            Object beforeObj = actions.get(before);
            Object nxtObj = actions.get(nxt);
            Long firstTime = beforeObj instanceof MouseActionDto ? ((MouseActionDto) beforeObj).getCreatedDate() : ((KeyboardActionDto) beforeObj).getCreatedDate();
            Long nxtTime = nxtObj instanceof MouseActionDto ? ((MouseActionDto) nxtObj).getCreatedDate() : ((KeyboardActionDto) nxtObj).getCreatedDate();

            int minus = Math.round((float) (nxtTime - firstTime) / Constants.NANO_TIME);
            customizedActions.add(beforeObj);
            if (minus >= 1){
                Long time = System.nanoTime();
                DelayTimeDto dto = new DelayTimeDto();
                dto.setCreatedDate(time);
                dto.setDelay((long) minus);
                dto.setActionType(Constants.DELAY_ACTION);
                customizedActions.add(dto);
            }
        });
        System.out.println("[SIZES]: "+customizedActions.size());
        return customizedActions;
    }
}
