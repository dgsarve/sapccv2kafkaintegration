/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.prakash.integration.setup;

import static com.prakash.integration.constants.KafkaintegrationConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import com.prakash.integration.constants.KafkaintegrationConstants;
import com.prakash.integration.service.KafkaintegrationService;


@SystemSetup(extension = KafkaintegrationConstants.EXTENSIONNAME)
public class KafkaintegrationSystemSetup
{
	private final KafkaintegrationService kafkaintegrationService;

	public KafkaintegrationSystemSetup(final KafkaintegrationService kafkaintegrationService)
	{
		this.kafkaintegrationService = kafkaintegrationService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		kafkaintegrationService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return KafkaintegrationSystemSetup.class.getResourceAsStream("/kafkaintegration/sap-hybris-platform.png");
	}
}
