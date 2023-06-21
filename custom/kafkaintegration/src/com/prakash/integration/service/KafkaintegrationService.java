/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.prakash.integration.service;

public interface KafkaintegrationService
{
	String getHybrisLogoUrl(String logoCode);

	void createLogo(String logoCode);
}
