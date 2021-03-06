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
package org.richfaces.test.picklist;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="http://community.jboss.org/people/bleathem">Brian Leathem</a>
 */
@RequestScoped
@Named
public class RichBean implements Serializable {

    private static final long serialVersionUID = -2403138958014741653L;
    private List<EntityBean> values;
    private List<String> strings;

    public RichBean() {
        System.out.println("post construct: initialize");
        values = new ArrayList<EntityBean>();
        values.add(new EntityBean("Option 1", "1"));
        values.add(new EntityBean("Option 2", "2"));
        values.add(new EntityBean("Option 3", "3"));
        values.add(new EntityBean("Option 4", "4"));

        strings = new ArrayList<String>();
//        strings.add("Option 2");
//        strings.add("Option 3");
    }

    public List<EntityBean> getValues() {
        return values;
    }

    public void setValues(List<EntityBean> values) {
        this.values = values;
    }

    public List<String> getStrings() {
        return strings;
    }

    public void setStrings(List<String> strings) {
        this.strings = strings;
    }
}
