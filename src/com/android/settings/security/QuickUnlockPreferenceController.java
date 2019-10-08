/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings.security;

import android.content.Context;
import android.os.UserHandle;
import android.provider.Settings;
import android.support.v7.preference.Preference;
import android.support.v7.preference.TwoStatePreference;

import com.android.internal.widget.LockPatternUtils;
import com.android.settings.core.BasePreferenceController;
import com.android.settings.core.TogglePreferenceController;

public class QuickUnlockPreferenceController extends TogglePreferenceController {

    private static final String QUICK_UNLOCK_ENABLED = "quick_unlock";

    public QuickUnlockPreferenceController(Context context) {
        super(context, QUICK_UNLOCK_ENABLED);
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE;
    }

    @Override
    public boolean isChecked() {
        return Settings.Secure.getIntForUser(mContext.getContentResolver(),
                Settings.Secure.QUICK_UNLOCK, 0, UserHandle.USER_CURRENT) != 0;
    }

    @Override
    public boolean setChecked(boolean isChecked) {
        Settings.Secure.putIntForUser(mContext.getContentResolver(),
                Settings.Secure.QUICK_UNLOCK, isChecked ? 1 : 0, UserHandle.USER_CURRENT);
        return true;
    }
}
