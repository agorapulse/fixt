/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2018-2021 Agorapulse.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.agorapulse.testing.officeunit

import spock.lang.Specification

class OfficeUnitDifferenceCollectorSpec extends Specification {

    void 'return zero on error'() {
        given:
            InputStream one = Mock(InputStream) {
                read(*_) >> { throw new IOException() }
            }
            InputStream two = Mock(InputStream) {
                read(*_) >> { throw new IOException() }
            }
        expect:
            OfficeUnitDifferenceCollector.INSTANCE.computeDifferences(
                '/root',
                one,
                two,
                Collections.emptySet()
            ).size() == 0
    }

}
