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

import org.jboss.arquillian.graphene.spi.annotations.Root;
import org.jboss.arquillian.graphene.spi.components.common.AbstractComponent;
import org.jboss.arquillian.graphene.spi.components.common.AbstractComponentStub;
import org.jboss.arquillian.graphene.spi.components.common.Component;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.ejb.ConcurrencyManagement;

/**
 * @author <a href="http://community.jboss.org/people/bleathem">Brian Leathem</a>
 */
public class LoginComponent extends AbstractComponent {

    @FindBy(id="loginForm:username")
    private WebElement usernameInput;

    @FindBy(id="loginForm:password")
    private WebElement passwordInput;

    @FindBy(id="loginForm:login")
    private WebElement loginButton;

    public void setUsername(Object username) {
        usernameInput.sendKeys(username.toString());
    }

    public void setPassword(Object password) {
        passwordInput.sendKeys(password.toString());
    }

    public void submit() {
        loginButton.submit();
    }
}