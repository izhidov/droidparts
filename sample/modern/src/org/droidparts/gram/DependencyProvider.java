/**
 * Copyright 2012 Alex Yanchenko
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */
package org.droidparts.gram;

import org.droidparts.gram.persist.DBOpenHelper;
import org.droidparts.gram.persist.ImageEntityManager;
import org.droidparts.gram.persist.PrefsManager;
import org.droidparts.inject.AbstractDependencyProvider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DependencyProvider extends AbstractDependencyProvider {

	private final DBOpenHelper dbOpenHelper;
	private PrefsManager prefsManager;
	private ImageEntityManager imageManager;

	public DependencyProvider(Context ctx) {
		super(ctx);
		dbOpenHelper = new DBOpenHelper(ctx);
	}

	@Override
	public SQLiteDatabase getDB() {
		return dbOpenHelper.getWritableDatabase();
	}

	public PrefsManager getPrefsManager(Context ctx) {
		if (prefsManager == null) {
			prefsManager = new PrefsManager(ctx);
		}
		return prefsManager;
	}

	public ImageEntityManager getImageEntityManager(Context ctx) {
		if (imageManager == null) {
			imageManager = new ImageEntityManager(ctx);
		}
		return imageManager;
	}

}
