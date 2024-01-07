/*
 * Copyright (C) 2017 Moez Bhatti <innovate.bhatti@gmail.com>
 *
 * This file is part of replify.
 *
 * replify is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * replify is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with replify.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.innovate.replify.interactor

import com.innovate.replify.repository.BackupRepository
import io.reactivex.Flowable
import javax.inject.Inject

class PerformRestore @Inject constructor(
    private val backupRepo: BackupRepository
) : Interactor<String>() {

    override fun buildObservable(params: String): Flowable<*> {
        return Flowable.just(params)
                .doOnNext(backupRepo::performRestore)
    }

}