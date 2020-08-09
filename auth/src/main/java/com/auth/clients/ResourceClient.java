package com.auth.clients;

import com.model.remotes.ResourceRemote;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "resource")
public interface ResourceClient extends ResourceRemote {


}
