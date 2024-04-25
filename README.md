# TD-Helm

Example project for a helm chart of a spring application

## Setup

- [Helm quickstart](https://helm.sh/docs/intro/quickstart/)
- [Kubernetes quickstart](https://kubernetes.io/de/docs/setup/)
- [ArgoCD quickstart](https://argo-cd.readthedocs.io/en/stable/getting_started/)

```bash
minikube start
```

```bash
minikube dashboard
```

```bash
k9s -A
```

```bash
helm repo add argo https://argoproj.github.io/argo-helm
```

```bash
helm install argocd argo/argo-cd -n argocd --create-namespace
```

```bash
kubectl create namespace td-dev
```

```shell
kubectl -n argocd get secret argocd-initial-admin-secret -o jsonpath="{.data.password}" | base64 -d
```

```bash
helm install test charts/simple-spring-app -n test --create-namespace
```

```bash
helm uninstall test -n test
```

## Helm Docs

```shell
docker run --rm --volume "$(pwd):/helm-docs" jnorwood/helm-docs:latest
```