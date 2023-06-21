package com.prakash.integration.listener;


import de.hybris.platform.core.PK;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.tx.AfterSaveEvent;
import de.hybris.platform.tx.AfterSaveListener;

import java.util.Collection;

public class GlobalAfterSaveEvent implements AfterSaveListener
{
    private ModelService modelService;

    public GlobalAfterSaveEvent(ModelService modelService) {
        this.modelService = modelService;
    }

    @Override
    public void afterSave(final Collection<AfterSaveEvent> events)
    {
        for (final AfterSaveEvent event : events)
        {
            final int type = event.getType();
            if (AfterSaveEvent.UPDATE == type)
            {
                final PK pk = event.getPk();
                //The User deployment code is "1"
                if (4 == pk.getTypeCode())
                {
                    final CustomerModel customerModel = modelService.get(pk);
                    String customerID = customerModel.getCustomerID();
                }
            }
        }
    }

   }
