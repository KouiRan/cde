/*!
 * Copyright 2002 - 2015 Webdetails, a Pentaho company. All rights reserved.
 *
 * This software was developed by Webdetails and is provided under the terms
 * of the Mozilla Public License, Version 2.0, or any later version. You may not use
 * this file except in compliance with the license. If you need a copy of the license,
 * please go to http://mozilla.org/MPL/2.0/. The Initial Developer is Webdetails.
 *
 * Software distributed under the Mozilla Public License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. Please refer to
 * the license for the specific language governing your rights and limitations.
 */

package pt.webdetails.cdf.dd.model.meta.writer.cderunjs.amd;

import pt.webdetails.cdf.dd.model.core.KnownThingKind;
import pt.webdetails.cdf.dd.model.core.Thing;
import pt.webdetails.cdf.dd.model.core.UnsupportedThingException;
import pt.webdetails.cdf.dd.model.core.writer.IThingWriter;
import pt.webdetails.cdf.dd.model.core.writer.IThingWriterFactory;
import pt.webdetails.cdf.dd.model.meta.writer.cderunjs.CdeRunJsPropertyTypeWriter;

public class CdeRunJsThingWriterFactory implements IThingWriterFactory {
  public IThingWriter getWriter( Thing t ) throws UnsupportedThingException {
    if ( t == null ) {
      throw new IllegalArgumentException( "t" );
    }

    String kind = t.getKind();

    if ( KnownThingKind.ComponentType.equals( kind ) ) {
      return new CdeRunJsComponentTypeWriter();
    }

    if ( KnownThingKind.PropertyType.equals( kind ) ) {
      return new CdeRunJsPropertyTypeWriter();
    }

    if ( KnownThingKind.MetaModel.equals( kind ) ) {
      return new CdeRunJsModelWriter();
    }

    throw new UnsupportedThingException( kind, t.getId() );
  }
}
