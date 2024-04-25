# simple-spring-app

![Version: 0.0.5](https://img.shields.io/badge/Version-0.0.5-informational?style=flat-square) ![Type: application](https://img.shields.io/badge/Type-application-informational?style=flat-square) ![AppVersion: 0.0.2](https://img.shields.io/badge/AppVersion-0.0.2-informational?style=flat-square)

A Helm chart for Kubernetes

## Requirements

| Repository | Name | Version |
|------------|------|---------|
| https://charts.bitnami.com/bitnami | postgresql | 15.2.5 |

## Values

| Key | Type | Default | Description |
|-----|------|---------|-------------|
| app.postgres.existingSecret | string | `"test-secret"` | Name of existing secret to use for PostgreSQL credentials. |
| app.postgres.jdbcurl | string | `"jdbc:postgresql://{{ .Release.Name }}-postgresql:5432/test"` | JDBC URL to the postgreSQL database |
| app.postgres.username | string | `"testuser"` | Name for the custom postgreSWL user |
| fullnameOverride | string | `""` | String to fully override simple-spring-app.fullname template |
| image.pullPolicy | string | `"IfNotPresent"` | [Kubernetes image pull policy](https://kubernetes.io/docs/concepts/containers/images/#image-pull-policy) to use |
| image.repository | string | `"dsjhartmann/simple-spring-app"` |  |
| image.tag | string | `""` |  |
| imagePullSecrets | list | `[]` | Existing image pull secret to use to [obtain the container image from private registries](https://kubernetes.io/docs/concepts/containers/images/#using-a-private-registry) |
| ingress.annotations | object | `{}` | Additional ingress annotations to add |
| ingress.className | string | `"nginx"` | Defines the [ingress class](https://kubernetes.io/docs/concepts/services-networking/ingress/#ingress-class)  to use |
| ingress.enabled | bool | `false` |  |
| ingress.hosts[0] | object | `{"host":"chart-example.local","paths":[{"path":"/","pathType":"ImplementationSpecific"}]}` | The hostname to be used to precisely map incoming traffic onto the underlying network service |
| ingress.hosts[0].paths[0] | object | `{"path":"/","pathType":"ImplementationSpecific"}` | path for incoming api calls |
| ingress.tls | list | `[]` |  |
| livenessProbe.failureThreshold | int | `10` | when a probe fails kubernetes will try 6 times before giving up |
| livenessProbe.httpGet.path | string | `"/actuator/health/liveness"` | Path to the service liveness endpoint |
| livenessProbe.httpGet.port | string | `"http"` |  |
| livenessProbe.initialDelaySeconds | int | `10` | seconds to wait before performing the first liveness check |
| livenessProbe.periodSeconds | int | `5` | this fields specifies that kubernetes should perform a liveness check every 10 seconds |
| livenessProbe.successThreshold | int | `1` | number of consecutive successes for the probe to be considered successful after having failed |
| livenessProbe.timeoutSeconds | int | `5` | number of seconds after which the probe times out |
| nameOverride | string | `""` | String to partially override simple-spring-app.fullname template (will maintain the release name) |
| podAnnotations | object | `{}` | additional annotations for the pod |
| podLabels | object | `{}` | additional labels for the pod |
| podSecurityContext | object | `{"fsGroup":3000,"runAsGroup":3000,"runAsUser":10000,"seccompProfile":{"type":"RuntimeDefault"}}` | The [pod security context](https://kubernetes.io/docs/tasks/configure-pod-container/security-context/#set-the-security-context-for-a-pod) defines privilege and access control settings for a Pod within the deployment |
| podSecurityContext.fsGroup | int | `3000` | The owner for volumes and any files created within volumes will belong to this guid |
| podSecurityContext.runAsGroup | int | `3000` | Processes within a pod will belong to this guid |
| podSecurityContext.runAsUser | int | `10000` | Runs all processes within a pod with a special uid |
| podSecurityContext.seccompProfile.type | string | `"RuntimeDefault"` | Restrict a Container's Syscalls with seccomp |
| postgresql.global.postgresql.auth.database | string | `"test"` | Name for a custom database to create (overrides `auth.database`) |
| postgresql.global.postgresql.auth.existingSecret | string | `"test-secret"` | Name of existing secret to use for PostgreSQL credentials (overrides `auth.existingSecret`). |
| postgresql.global.postgresql.auth.secretKeys.adminPasswordKey | string | `"postgresAdminPassword"` | Name of key in existing secret to use for PostgreSQL credentials (overrides `auth.secretKeys.adminPasswordKey`). Only used when `global.postgresql.auth.existingSecret` is set. |
| postgresql.global.postgresql.auth.secretKeys.userPasswordKey | string | `"postgresPassword"` | Name of key in existing secret to use for PostgreSQL credentials (overrides `auth.secretKeys.userPasswordKey`). Only used when `global.postgresql.auth.existingSecret` is set. |
| postgresql.global.postgresql.auth.username | string | `"testuser"` | Name for a custom user to create (overrides `auth.username`) |
| postgresql.primary.persistence.enabled | bool | `false` | Enable PostgreSQL Primary data persistence using PVC |
| postgresql.primary.persistence.size | string | `"1Gi"` | PVC Storage Request for PostgreSQL volume |
| readinessProbe.failureThreshold | int | `10` | when a probe fails kubernetes will try 6 times before giving up |
| readinessProbe.httpGet.path | string | `"/actuator/health/readiness"` | Path to the service readiness endpoint |
| readinessProbe.httpGet.port | string | `"http"` |  |
| readinessProbe.initialDelaySeconds | int | `10` | seconds to wait before performing the first readiness check |
| readinessProbe.periodSeconds | int | `5` | this fields specifies that kubernetes should perform a readiness check every 10 seconds |
| readinessProbe.successThreshold | int | `1` | number of consecutive successes for the probe to be considered successful after having failed |
| readinessProbe.timeoutSeconds | int | `5` | number of seconds after which the probe times out |
| resources | object | `{"limits":{"cpu":"500m","memory":"0.5Gi"},"requests":{"cpu":"500m","memory":"0.5Gi"}}` | Set container requests and limits for different resources like CPU or memory (essential for production workloads) |
| securityContext.allowPrivilegeEscalation | bool | `false` | Controls [Privilege Escalation](https://kubernetes.io/docs/concepts/security/pod-security-policy/#privilege-escalation) enabling setuid binaries changing the effective user ID |
| securityContext.capabilities.add | list | `[]` | Specifies which capabilities to add to issue specialized syscalls |
| securityContext.capabilities.drop | list | `["ALL"]` | Specifies which capabilities to drop to reduce syscall attack surface |
| securityContext.readOnlyRootFilesystem | bool | `true` | Whether the root filesystem is mounted in read-only mode |
| securityContext.runAsGroup | int | `3000` | The container's process will run with the specified gid |
| securityContext.runAsNonRoot | bool | `true` | Requires the container to run without root privileges |
| securityContext.runAsUser | int | `10000` | The container's process will run with the specified uid |
| service.port | int | `8080` | port for incoming api calls |
| service.type | string | `"ClusterIP"` | [Service type](https://kubernetes.io/docs/concepts/services-networking/service/#publishing-services-service-types) to expose the running application on a set of Pods as a network service. |

----------------------------------------------
Autogenerated from chart metadata using [helm-docs v1.13.1](https://github.com/norwoodj/helm-docs/releases/v1.13.1)
