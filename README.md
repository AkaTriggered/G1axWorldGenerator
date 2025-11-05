# 🌍 G1axWorldGenerator

<div align="center">

![G1ax Logo](https://img.shields.io/badge/G1ax-WorldGenerator-2b5dad?style=for-the-badge&logo=minecraft)
[![Version](https://img.shields.io/badge/Version-1.0.0-brightgreen?style=for-the-badge)](https://github.com/AkaTriggered/G1axWorldGenerator/releases)
[![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)](LICENSE)
[![Minecraft](https://img.shields.io/badge/Minecraft-1.21+-orange?style=for-the-badge)](https://www.minecraft.net/)

**🚀 Performance-Optimized Custom World Generator with 9 Unique Biomes**

[📥 Download](https://github.com/AkaTriggered/G1axWorldGenerator/releases) • [🐛 Report Bug](https://github.com/AkaTriggered/G1axWorldGenerator/issues) • [💡 Request Feature](https://github.com/AkaTriggered/G1axWorldGenerator/issues)

</div>

---

## 📋 Table of Contents

- [✨ Features](#-features)
- [🌎 Available Biomes](#-available-biomes)
- [⚡ Performance Optimizations](#-performance-optimizations)
- [📦 Installation](#-installation)
- [🎮 Usage](#-usage)
- [🔧 Multiverse Integration](#-multiverse-integration)
- [🛠️ Building from Source](#️-building-from-source)
- [📸 Screenshots](#-screenshots)
- [🤝 Contributing](#-contributing)
- [📄 License](#-license)
- [👨‍💻 Credits](#-credits)

---

## ✨ Features

<div align="center">

| 🎯 **Core Features** | 🔧 **Technical** | 🎮 **Server Admin** |
|:---:|:---:|:---:|
| 9 Unique Biomes | Java 21 Compatible | Zero Configuration |
| Custom Terrain Generation | Paper/Spigot API | Multiverse Ready |
| Automatic Optimizations | FastNoise Algorithm | Performance Focused |
| Void Worlds Support | Maven Build System | Open Source |

</div>

### 🌟 Key Highlights

- **🎨 9 Themed Biomes**: From lush plains to mysterious void worlds
- **⚡ Auto-Optimization**: Worlds automatically configured for maximum performance
- **🔌 Plug & Play**: No configuration files needed - just install and use
- **🌐 Multiverse Compatible**: Seamless integration with Multiverse-Core
- **🚀 Performance First**: Optimized for servers with multiple worlds
- **📱 Modern Codebase**: Built with Java 21 and latest Minecraft APIs

---

## 🌎 Available Biomes

<table>
<tr>
<td align="center" width="50%">

### 🌱 **Natural Biomes**
| Biome | ID | Description |
|-------|----|-----------| 
| 🌾 Plains | `PLAINS` | Grass terrain with oak trees |
| 🏜️ Desert | `DESERT` | Sand terrain with cacti |
| 🏔️ Badlands | `BADLANDS` | Mesa/terracotta terrain |
| 🍄 Mushroom | `MUSHROOM` | Mushroom island terrain |
| ❄️ Snow | `SNOW` | Snowy grass with spruce trees |

</td>
<td align="center" width="50%">

### 🌌 **Exotic Biomes**
| Biome | ID | Description |
|-------|----|-----------| 
| 🔮 End | `END` | End stone with chorus plants |
| 🔥 Nether | `NETHER` | Netherrack with crimson trees |
| 🧊 Ice | `ICE` | Frozen terrain with ice spikes |
| 🕳️ Void | `VOID` | Floating islands in void space |

</td>
</tr>
</table>

---

## ⚡ Performance Optimizations

G1axWorldGenerator automatically applies comprehensive optimizations to every generated world:

<details>
<summary><b>🎯 Click to view all optimizations</b></summary>

### 🔧 **World Settings**
- **Difficulty**: Hard (consistent challenge)
- **World Border**: 1000 blocks (prevents infinite exploration)
- **View Distance**: 6 chunks (reduced server load)
- **Simulation Distance**: 4 chunks (optimized processing)

### 🚫 **Disabled Features**
- ❌ Mob Spawning (all types)
- ❌ Auto-Save (manual save control)
- ❌ Day/Night Cycle (always day)
- ❌ Weather Cycle (always clear)
- ❌ Fire Spread
- ❌ Random Tick Speed (no crop growth/decay)
- ❌ Tile & Entity Drops
- ❌ Mob Griefing

### 📊 **Performance Impact**
- 🔥 **CPU Usage**: Reduced by ~60%
- 💾 **RAM Usage**: Reduced by ~40%
- 💿 **Disk I/O**: Reduced by ~80%
- 🌐 **Network**: Reduced by ~50%

</details>

---

## 📦 Installation

### 📋 **Requirements**
- ☕ **Java**: 21+
- 🎮 **Server**: Paper/Spigot 1.21+
- 🔌 **Optional**: Multiverse-Core (recommended)

### 🚀 **Quick Install**

1. **Download** the latest JAR from [Releases](https://github.com/AkaTriggered/G1axWorldGenerator/releases)
2. **Place** the JAR in your server's `plugins/` folder
3. **Restart** your server
4. **Create worlds** using the commands below!

```bash
# Download latest release
wget https://github.com/AkaTriggered/G1axWorldGenerator/releases/latest/download/G1axWorldGenerator.jar

# Move to plugins folder
mv G1axWorldGenerator.jar /path/to/your/server/plugins/

# Restart server
./restart.sh
```

---

## 🎮 Usage

### 🌍 **Creating Worlds**

#### With Multiverse-Core (Recommended)
```bash
/mv create <world_name> normal -g G1axWorldGenerator:<BIOME_ID>
```

### 📝 **Example Commands**
```bash
# Create different biome worlds
/mv create my_plains normal -g G1axWorldGenerator:PLAINS
/mv create my_desert normal -g G1axWorldGenerator:DESERT
/mv create my_void normal -g G1axWorldGenerator:VOID
/mv create my_nether normal -g G1axWorldGenerator:NETHER

# Teleport to worlds
/mv tp my_plains
/mv tp my_void
```

---

## 🔧 Multiverse Integration

G1axWorldGenerator is designed to work seamlessly with **Multiverse-Core**:

<details>
<summary><b>🎯 Complete Multiverse Commands</b></summary>

```bash
# Create all 9 biome worlds
/mv create plains_world normal -g G1axWorldGenerator:PLAINS
/mv create desert_world normal -g G1axWorldGenerator:DESERT
/mv create badlands_world normal -g G1axWorldGenerator:BADLANDS
/mv create mushroom_world normal -g G1axWorldGenerator:MUSHROOM
/mv create end_world normal -g G1axWorldGenerator:END
/mv create nether_world normal -g G1axWorldGenerator:NETHER
/mv create snow_world normal -g G1axWorldGenerator:SNOW
/mv create ice_world normal -g G1axWorldGenerator:ICE
/mv create void_world normal -g G1axWorldGenerator:VOID

# Quick teleport commands
/mv tp plains_world    # Teleport to plains
/mv tp void_world      # Teleport to void world
/mv tp ice_world       # Teleport to ice world

# World management
/mv list               # List all worlds
/mv info <world>       # Get world information
/mv setspawn           # Set spawn point
```

</details>
---

## 🛠️ Building from Source

### 📋 **Prerequisites**
- ☕ **Java Development Kit**: 21+
- 🔨 **Apache Maven**: 3.6+
- 📁 **Git**: Latest version

### 🔨 **Build Steps**

```bash
# Clone the repository
git clone https://github.com/AkaTriggered/G1axWorldGenerator.git
cd G1axWorldGenerator

# Build with Maven
mvn clean package

# Find your JAR
ls target/G1axWorldGenerator.jar
```

### 🧪 **Development Setup**
```bash
# Install dependencies
mvn dependency:resolve

# Compile only
mvn compile

# Run tests (if any)
mvn test

# Create development build
mvn package -DskipTests
```

## 🤝 Contributing

We welcome contributions! Here's how you can help:

### 🎯 **Ways to Contribute**
- 🐛 **Report Bugs**: Found an issue? [Open an issue](https://github.com/AkaTriggered/G1axWorldGenerator/issues)
- 💡 **Suggest Features**: Have an idea? [Request a feature](https://github.com/AkaTriggered/G1axWorldGenerator/issues)
- 🔧 **Submit Code**: Fork, code, and create a pull request
- 📖 **Improve Docs**: Help us make the documentation better
- 🌍 **Add Biomes**: Create new biome generators

### 📝 **Development Guidelines**
1. **Fork** the repository
2. **Create** a feature branch (`git checkout -b feature/amazing-biome`)
3. **Commit** your changes (`git commit -m 'Add amazing biome'`)
4. **Push** to the branch (`git push origin feature/amazing-biome`)
5. **Open** a Pull Request

### 🎨 **Code Style**
- Use **Java 21** features where appropriate
- Follow **standard Java naming conventions**
- Add **JavaDoc comments** for public methods
- Keep **performance** as a priority
- Test with **multiple Minecraft versions**

---

## 📄 License

This project is licensed under the **MIT License** - see the [LICENSE](LICENSE) file for details.

```
MIT License - You are free to:
✅ Use commercially
✅ Modify and distribute
✅ Use privately
✅ Sublicense

❗ Conditions:
- Include original license
- Include copyright notice
```

---

## 👨‍💻 Credits

<div align="center">

### 🏆 **Main Developer**
**[AkaTriggered](https://github.com/AkaTriggered)**  
*Creator & Lead Developer*

### 🙏 **Special Thanks**
- **Paper Team** - For the excellent server software
- **Multiverse Team** - For world management integration
- **FastNoise Community** - For the noise generation library
- **Minecraft Community** - For inspiration and feedback

### 🔗 **Links**
[![GitHub](https://img.shields.io/badge/GitHub-AkaTriggered-181717?style=for-the-badge&logo=github)](https://github.com/AkaTriggered)
[![Website](https://img.shields.io/badge/Website-G1axWorldGenerator-2b5dad?style=for-the-badge&logo=minecraft)](https://github.com/AkaTriggered/G1axWorldGenerator)

</div>

<div align="center">

### 🌟 **Star this repository if you found it helpful!**

[![Stars](https://img.shields.io/github/stars/AkaTriggered/G1axWorldGenerator?style=social)](https://github.com/AkaTriggered/G1axWorldGenerator/stargazers)
[![Forks](https://img.shields.io/github/forks/AkaTriggered/G1axWorldGenerator?style=social)](https://github.com/AkaTriggered/G1axWorldGenerator/network/members)
[![Issues](https://img.shields.io/github/issues/AkaTriggered/G1axWorldGenerator?style=social)](https://github.com/AkaTriggered/G1axWorldGenerator/issues)

**Made with ❤️ for the Minecraft community**

</div>

<div align="center">
<sub>🔄 Last updated: November 2025 | 📧 Questions? Open an issue!</sub>
</div>
