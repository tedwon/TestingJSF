/**
 * JBoss, Home of Professional Open Source
 * Copyright 2010, Red Hat, Inc. and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 **/
package org.richfaces.test.graphene;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.jboss.arquillian.drone.api.annotation.Drone;
import com.thoughtworks.selenium.DefaultSelenium;

import java.io.File;
import java.net.URL;

/**
 * @author <a href="http://community.jboss.org/people/bleathem">Brian Leathem</a>
 */

@RunWith(Arquillian.class)
@Ignore
public class LoginScreenSeleniumTest {
    private static final String WEBAPP_SRC = "src/main/webapp";

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "login.war")
                .addClasses(Credentials.class, User.class, LoginController.class)
                .addAsWebResource(new File(WEBAPP_SRC, "login.xhtml"))
                .addAsWebResource(new File(WEBAPP_SRC, "home.xhtml"))
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsWebInfResource(
                        new StringAsset("<faces-config version=\"2.0\"/>"),
                        "faces-config.xml");
    }

    @Drone
    DefaultSelenium browser;

    @ArquillianResource
    URL deploymentURL;

    @Test
    public void should_login_successfully() {
        browser.open(deploymentURL + "login.jsf");

        browser.type("id=loginForm:username", "demo");
        browser.type("id=loginForm:password", "demo");
        browser.click("id=loginForm:login");
        browser.waitForPageToLoad("15000");

        Assert.assertTrue("User should be logged in!",
                browser.isElementPresent("xpath=//li[contains(text(), 'Welcome')]"));
    }

}