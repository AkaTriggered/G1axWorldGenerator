# G1axWorldGenerator

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Paper](https://img.shields.io/badge/Paper-1.21.4-blue.svg)](https://papermc.io/)
[![Version](https://img.shields.io/badge/Version-1.0.0-green.svg)](https://github.com/AkaTriggered/G1axWorldGenerator/releases)

A powerful and customizable world generator plugin for Minecraft Paper/Spigot servers, featuring multiple biome-specific generators with advanced noise-based terrain generation.

## ✨ Features

- **Multiple World Generators**: Plains, Desert, Badlands, and Mushroom biome generators
- **Advanced Noise Generation**: Utilizes FastNoiseLite for realistic terrain generation
- **Biome-Specific Populators**: Custom structure and feature generation for each biome
- **Paper/Spigot Compatible**: Works with Paper 1.21.4+ and Spigot servers
- **Lightweight**: Optimized performance with minimal server impact
- **Easy Integration**: Simple setup with Multiverse or other world management plugins

## 🚀 Installation

1. Download the latest release from [Releases](https://github.com/AkaTriggered/G1axWorldGenerator/releases)
2. Place the `G1axWorldGenerator.jar` file in your server's `plugins` folder
3. Restart your server
4. Use with world management plugins like Multiverse

## 🌍 World Generators

### Plains Generator
- Rolling hills and flat plains
- Natural grass and flower generation
- Village-friendly terrain

### Desert Generator  
- Sand dunes and desert terrain
- Cactus and dead bush population
- Desert temple compatible

### Badlands Generator
- Mesa-style terrain with layered blocks
- Red sand and terracotta formations
- Unique geological features

### Mushroom Generator
- Mushroom island terrain
- Mycelium ground cover
- Giant mushroom structures

## 🔧 Usage

### With Multiverse
```
/mv create <worldname> normal -g G1axWorldGenerator:plains
/mv create <worldname> normal -g G1axWorldGenerator:desert  
/mv create <worldname> normal -g G1axWorldGenerator:badlands
/mv create <worldname> normal -g G1axWorldGenerator:mushroom
```

### With Other Plugins
Use the generator name format: `G1axWorldGenerator:<type>`
- `G1axWorldGenerator:plains`
- `G1axWorldGenerator:desert`
- `G1axWorldGenerator:badlands`
- `G1axWorldGenerator:mushroom`

## 🛠️ Building from Source

### Prerequisites
- Java 21 or higher
- Maven 3.6+

### Build Steps
```bash
git clone https://github.com/AkaTriggered/G1axWorldGenerator.git
cd G1axWorldGenerator
mvn clean package
```

The compiled JAR will be in the `target/` directory.

## 🤝 Contributing

We welcome contributions! Here's how you can help:

1. **Fork** the repository
2. **Create** a feature branch (`git checkout -b feature/amazing-feature`)
3. **Commit** your changes (`git commit -m 'Add amazing feature'`)
4. **Push** to the branch (`git push origin feature/amazing-feature`)
5. **Open** a Pull Request

### Contribution Guidelines
- Follow Java coding standards
- Add comments for complex logic
- Test your changes thoroughly
- Update documentation if needed

## 📋 Requirements

- **Server**: Paper 1.21.4+ or Spigot 1.21.4+
- **Java**: Version 21 or higher
- **Memory**: Minimal additional RAM usage

## 🐛 Bug Reports & Feature Requests

Found a bug or have a feature idea? Please [open an issue](https://github.com/AkaTriggered/G1axWorldGenerator/issues) with:

- **Bug Reports**: Steps to reproduce, expected vs actual behavior, server version
- **Feature Requests**: Clear description of the feature and use case

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🙏 Acknowledgments

- [FastNoiseLite](https://github.com/Auburn/FastNoiseLite) for noise generation
- [PaperMC](https://papermc.io/) for the excellent server software
- The Minecraft modding community for inspiration

## 📞 Support

- **Issues**: [GitHub Issues](https://github.com/AkaTriggered/G1axWorldGenerator/issues)
- **Discussions**: [GitHub Discussions](https://github.com/AkaTriggered/G1axWorldGenerator/discussions)
- **Author**: [AkaTriggered](https://github.com/AkaTriggered)

---

⭐ **Star this repository if you find it useful!**
