package ru.real.backend.api.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.real.backend.api.dto.UserDto;
import ru.real.backend.api.search.UserSearchDto;
import ru.real.backend.core.resource.BaseResource;

@RequestMapping
public interface UserResource extends BaseResource<UserDto, UserSearchDto> {
    @GetMapping("/find-by-username/{username}")
    ResponseEntity<UserDto> findByUsername(@PathVariable String username);

    @DeleteMapping("/delete-by-username/{username}")
    ResponseEntity<Void> deleteByUsername(@PathVariable String username);
}
