ModsDotGroovy.make {
    def modid = this.buildProperties["mod_id"]

    modLoader = "javafml"
    loaderVersion = "[${(this.buildProperties["forge_version"] as String).split("\\.")[0]},)"

    license = "MIT"
    issueTrackerUrl = ""

    mod {
        modId = modid
        displayName = this.buildProperties["mod_name"]
        version = this.version
        group = this.group
        authors = [this.buildProperties["mod_author"] as String]

        displayUrl = ""
        sourcesUrl = ""
        logoFile = "logo.png"
        description = ""

        onFabricAndQuilt {
            entrypoints {
                main = ""
                client = ""
            }
        }

        onQuilt {
            intermediateMappings = "net.fabricmc:intermediary"
        }

        dependencies {
            onForge {
                minecraft = this.minecraftVersionRange
                forge = "[${this.forgeVersion},)"
            }

            onFabric {
                minecraft = this.minecraftVersion
                fabricloader = ">=${this.fabricLoaderVersion}"
            }

            onQuilt {
                minecraft = this.minecraftVersion
                quilt_loader = ">=${this.quiltLoaderVersion}"
                quilted_fabric_api = ">=${this.buildProperties["quilted_fabric_version"]}"
                quilt_base = ">=${this.buildProperties["qsl_version"]}"
            }
        }
    }

    onFabricAndQuilt {
        environment = "*"
        mixin = [
                modid + ".mixins.json"
        ]
    }
}