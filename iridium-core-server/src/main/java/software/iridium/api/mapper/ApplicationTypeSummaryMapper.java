/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package software.iridium.api.mapper;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import software.iridium.api.authentication.domain.ApplicationTypeSummary;
import software.iridium.entity.ApplicationTypeEntity;

@Component
public class ApplicationTypeSummaryMapper {

  public List<ApplicationTypeSummary> mapToList(final List<ApplicationTypeEntity> entities) {
    if (entities.isEmpty()) {
      return Collections.emptyList();
    }
    return entities.stream().map(this::map).collect(Collectors.toList());
  }

  public ApplicationTypeSummary map(final ApplicationTypeEntity entity) {
    return ApplicationTypeSummary.of(entity.getId(), entity.getName(), entity.getDescription());
  }
}
