# telecom-network

Monorepo for a three-service telecom portal stack: two Spring Boot Java services and an Angular UI, deployed to Kubernetes via ArgoCD.

## Layout

```text
.
├── .github/workflows/   # GitHub Actions: yamllint + kubeconform + compose config
├── argocd/              # ArgoCD Application CRD
├── manifests/base/      # Kustomize base: Deployments + Services
├── services/
│   ├── my-telecom-portal/    # Spring Boot 2.1 (Java 8) + Zuul gateway, port 8181
│   ├── my-telecom-account/   # Spring Boot 2.1 (Java 8), port 8282
│   └── my-portal-ui/         # Angular CLI (Node 10), port 4200
└── docker-compose.yaml  # Local dev (no Swarm)
```

Service source was recovered from upstream repos under [github.com/satishsahu](https://github.com/satishsahu) (origin of the original training images).

## Services

| Service              | Stack            | Port  | Image                                          |
| -------------------- | ---------------- | ----- | ---------------------------------------------- |
| `my-telecom-portal`  | Spring Boot 2.1  | 8181  | `ghcr.io/arnabdey73/my-telecom-portal:latest`  |
| `my-telecom-account` | Spring Boot 2.1  | 8282  | `ghcr.io/arnabdey73/my-telecom-account:latest` |
| `my-portal-ui`       | Angular (ng-cli) | 4200  | `ghcr.io/arnabdey73/my-portal-ui:latest`       |

## Run locally with Docker Compose

```bash
docker compose up --build
```

Each service has a multi-stage `Dockerfile` and is built from `./services/<name>`.

## Deploy with ArgoCD

```bash
kubectl apply -f argocd/application.yaml
```

ArgoCD will create the `telecom-network` namespace and sync the manifests under [manifests/base/](manifests/base/) (auto-prune + self-heal enabled). Update [argocd/application.yaml](argocd/application.yaml) `repoURL` to match your fork.

## Render manifests locally

```bash
kustomize build manifests/base
```

## CI

GitHub Actions workflow at [.github/workflows/ci.yml](.github/workflows/ci.yml) is currently `workflow_dispatch`-only — re-enable the push/PR triggers once the ArgoCD target cluster is configured.
