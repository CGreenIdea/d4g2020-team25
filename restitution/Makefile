default: clean documents

# Get some nice Fonts for rendering
fonts:
	# Download the package (Calibri)
	wget -O src/resources/fonts/fonts.zip https://cdn.freefontsvault.com/wp-content/uploads/2020/06/15194108/calibri-font.zip
	# Unzip the package and overwrite existing fonts
	unzip -o src/resources/fonts/fonts.zip -d src/resources/fonts/
	# Do the same for M+ 1mn
	wget -O src/resources/fonts/fonts.zip https://get.fontspace.co/download/family/wmqp/23f78990cfab4d7db1091e8bcaeec421/m-1mn-font.zip
	# Unzip the package and overwrite existing fonts
	unzip -o src/resources/fonts/fonts.zip -d src/resources/fonts/
	# Clean up
	rm src/resources/fonts/fonts.zip

# Remove previous builds
clean:
	rm -fv restitution-d4g-team25.pdf

# Compile each document file into its own PDF
documents:
	asciidoctor-pdf \
			-o restitution-d4g-team25.pdf \
			-a doctype=article \
			-a pdf-stylesdir=src/resources/themes \
			-a pdf-style=d4g-theme.yml \
			-a pdf-fontsdir=src/resources/fonts \
			-a imagesdir=images \
			src/asciidoctor/restitution-d4g-team25.adoc
